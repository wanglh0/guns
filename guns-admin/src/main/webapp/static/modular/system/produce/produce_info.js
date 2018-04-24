/**
 * 初始化详情对话框
 */
var ProduceInfoDlg = {
    produceInfoData : {}
};

/**
 * 清除数据
 */
ProduceInfoDlg.clearData = function() {
    this.produceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProduceInfoDlg.set = function(key, val) {
    this.produceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProduceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProduceInfoDlg.close = function() {
    parent.layer.close(window.parent.Produce.layerIndex);
}

/**
 * 收集数据
 */
ProduceInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('dictid')
    .set('price');
}

/**
 * 提交添加
 */
ProduceInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/produce/add", function(data){
        Feng.success("添加成功!");
        window.parent.Produce.table.refresh();
        ProduceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.produceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProduceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/produce/update", function(data){
        Feng.success("修改成功!");
        window.parent.Produce.table.refresh();
        ProduceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.produceInfoData);
    ajax.start();
}

$(function() {

});
