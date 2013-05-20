Ember.TEMPLATES['administration/alertPlugins'] = Ember.Handlebars.compile('' +
    '<div id="adminTabLeftMenu">' +
        '{{view Ember.TextField valueBinding="newAdminPluginName" classNames="input-medium mediumTopPadding"}}' +
        '<button class="btn" {{action createNewAlertPlugin}}>Add</button>' +
        '{{view Montric.SelectableListView listItemsBinding="content" deleteAction="deleteSelectedAlertPlugin" selectedItemBinding="controller.selectedItem"}}' +
    '</div>' +

    '{{#if selectedItem}}' +
        '<div id="adminTabRightContent">' +
            '<h1>{{selectedItem.id}}</h1>' +
            '<table class="table">' +
            '<tr>' +
                '<td>Activated:</td>' +
                '<td colspan="3">{{view Ember.Checkbox checkedBinding="selectedItem.alertActivated"}}</td>' +
            '</tr>' +
            '<tr>' +
                '<td>Access Token:</td>' +
                '<td>{{selectedItem.id}}</td>' +
            '</tr>' +
            '<tr>' +
                '<td>Access Token Name:</td>' +
                '<td>{{selectedItem.accessTokenName}}</td>' +
            '</tr>' +
            '<tr>' +
                '<td>Account Name:</td>' +
                '<td>{{selectedItem.accountName}}</td>' +
            '</tr>' +
            '</table>' +
        '</div>' +
    '{{/if}}'
    //'{{view Montric.ConfirmDialogView elementId="adminAlertConfirmDialog" cancelButtonLabel="Cancel" cancelAction="doCancelAlertDeletion" okButtonLabel="Delete" okAction="doConfirmDeletion" target="controller" header="Delete Access Token?" message="Are you sure you want to delete the selected access token? This action will permanently remove the alert from the system. This action cannot be undone!"}}'
);