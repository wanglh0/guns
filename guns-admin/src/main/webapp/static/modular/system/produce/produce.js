/**
 * 管理初始化
 */
var Produce = {
    id: "ProduceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Produce.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '代理id', field: 'dictid', visible: true, align: 'center', valign: 'middle'},
            {title: '代理级别', field: 'dictname', visible: true, align: 'center', valign: 'middle'},
            {title: '价钱', field: 'price', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Produce.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Produce.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
Produce.openAddProduce = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/produce/produce_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
Produce.openProduceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/produce/produce_update/' + Produce.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
Produce.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/produce/delete", function (data) {
            Feng.success("删除成功!");
            Produce.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("produceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
Produce.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Produce.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Produce.initColumn();
    var table = new BSTable(Produce.id, "/produce/list", defaultColunms);
    table.setPaginationType("client");
    Produce.table = table.init();
});
