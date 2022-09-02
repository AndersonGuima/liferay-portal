<#macro treeview_item
	cssClassTreeItem = ""
	frequency = 0
	id = ""
	isFrequencyVisible = true
	isSelectable = false
	isSelected = false
	name = ""
	termDisplayContexts = ""
>
	<li class="treeview-item" role="none">
		<div
			aria-controls="${namespace}treeItem${id}"
			aria-expanded="true"
			class="treeview-link ${cssClassTreeItem}"
			data-target="#${namespace}treeItem${id}"
			data-toggle="collapse"
			onClick="${namespace}toggleTreeItem('${namespace}treeItem${id}');"
			role="treeitem"
			tabindex="0"
		>
			<span class="c-inner" tabindex="-2">
				<span class="autofit-row">
					<#if termDisplayContexts?has_content>
						<span class="autofit-col">
							<button
								aria-controls="${namespace}treeItem${id}"
								aria-expanded="true"
								class="btn btn-monospaced component-expander"
								data-target="#${namespace}treeItem${id}"
								data-toggle="collapse"
								tabindex="-1"
								type="button"
							>
								<span class="c-inner" tabindex="-2">
									<@clay["icon"] symbol="angle-down" />

									<@clay["icon"]
										cssClass="component-expanded-d-none"
										symbol="angle-right"
									/>
								</span>
							</button>
						</span>
					</#if>

					<#if isSelectable>
						<span class="autofit-col autofit-col-expand">
							<div class="custom-checkbox custom-control">
								<label>
									<input
										${isSelected?then("checked", "")}
										class="custom-control-input facet-term"
										data-term-id=${id}
										disabled
										onChange="Liferay.Search.FacetUtil.changeSelection(event);"
										type="checkbox"
									/>

									<span class="custom-control-label">
										<span class="custom-control-label-text">
											${name}

											<#if isFrequencyVisible>
												(${frequency})
											</#if>
										</span>
									</span>
								</label>
							</div>
						</span>
					<#else>
						<span class="autofit-col autofit-col-expand">
							<span class="component-text">
								<span
									class="text-truncate-inline"
									title="${name}"
								>
									<span class="text-truncate">
										${name}

										<#if isFrequencyVisible>
											(${frequency})
										</#if>
									</span>
								</span>
							</span>
						</span>
					</#if>
				</span>
			</span>
		</div>

		<#if termDisplayContexts?has_content>
			<div class="collapse show" id="${namespace}treeItem${id}">
				<ul class="treeview-group" role="group">
					<#list termDisplayContexts as termDisplayContext>
						<@treeview_item
							cssClassTreeItem="tree-item-category"
							frequency=termDisplayContext.getFrequency()
							id=termDisplayContext.getAssetCategoryId()
							isFrequencyVisible=termDisplayContext.isFrequencyVisible()
							isSelectable=true
							isSelected=termDisplayContext.isSelected()
							name=htmlUtil.escape(termDisplayContext.getDisplayName())
						/>
					</#list>
				</ul>
			</div>
		</#if>
	</li>
</#macro>

<@liferay_ui["panel-container"]
	extended=true
	id="${namespace + 'facetAssetCategoriesPanelContainer'}"
	markupView="lexicon"
	persistState=true
>
	<@liferay_ui.panel
		collapsible=true
		cssClass="search-facet search-facet-display-vocabulary"
		id="${namespace + 'facetAssetCategoriesPanel'}"
		markupView="lexicon"
		persistState=true
		title="category"
	>
		<#if assetCategoriesSearchFacetDisplayContext.getVocabularyNames()?has_content>
			<ul class="treeview treeview-light treeview-nested treeview-vocabulary-display" role="tree">
				<#list assetCategoriesSearchFacetDisplayContext.getVocabularyNames() as vocabularyName>
					<@treeview_item
						cssClassTreeItem="tree-item-vocabulary"
						id=vocabularyName + vocabularyName?index
						isFrequencyVisible=false
						name=htmlUtil.escape(vocabularyName)
						termDisplayContexts=assetCategoriesSearchFacetDisplayContext.getTermDisplayContexts(vocabularyName)
					/>
				</#list>
			</ul>
		</#if>

		<#if !assetCategoriesSearchFacetDisplayContext.isNothingSelected()>
			<@liferay_aui.button
				cssClass="btn-link btn-unstyled facet-clear-btn"
				onClick="Liferay.Search.FacetUtil.clearSelections(event);"
				value="clear"
			/>
		</#if>
	</@>
</@>

<@liferay_aui.script>
	function ${namespace}toggleTreeItem(dataTarget) {
		const dataTargetElements = document.querySelectorAll("[data-target=\"#" + dataTarget + "\"]");

		dataTargetElements.forEach(
			element => {
				if (element.classList.contains('collapsed')) {
					element.classList.remove('collapsed');
					element.setAttribute('aria-expanded', true);
				}
				else {
					element.classList.add('collapsed');
					element.setAttribute('aria-expanded', false);
				}
			}
		);

		const subtreeCategoryTreeElement = document.getElementById(dataTarget);

		if (subtreeCategoryTreeElement) {
			if (subtreeCategoryTreeElement.classList.contains('show')) {
				subtreeCategoryTreeElement.classList.remove('show');
			}
			else {
				subtreeCategoryTreeElement.classList.add('show');
			}
		}
	}
</@>