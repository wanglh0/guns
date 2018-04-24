/**
 * 管理初始化
 */
var Crdl = {
    id: "CrdlTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Crdl.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '名字', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '当前时间', field: 'nowdate', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'updatetime', visible: true, align: 'center', valign: 'middle'},
            {title: '联系方式', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '代理字典id', field: 'dictid', visible: true, align: 'center', valign: 'middle'},
            {title: '代理级别', field: 'dictname', visible: true, align: 'center', valign: 'middle'},
            {title: '成本', field: 'price1', visible: true, align: 'center', valign: 'middle'},
            {title: '应收钱', field: 'price2', visible: true, align: 'center', valign: 'middle'},
            {title: '实际收钱', field: 'price3', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Crdl.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Crdl.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Crdl.openAddCrdl = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/crdl/crdl_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Crdl.openCrdlDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/crdl/crdl_update/' + Crdl.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Crdl.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/crdl/delete", function (data) {
            Feng.success("删除成功!");
            Crdl.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("crdlId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Crdl.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Crdl.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Crdl.initColumn();
    var table = new BSTable(Crdl.id, "/crdl/list", defaultColunms);
    table.setPaginationType("client");
    Crdl.table = table.init();
});
