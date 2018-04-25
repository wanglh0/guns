/**
 * 初始化详情对话框
 */
var CrdlInfoDlg = {
    crdlInfoData: {}
};

/**
 * 清除数据
 */
CrdlInfoDlg.clearData = function () {
    this.crdlInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CrdlInfoDlg.set = function (key, val) {
    this.crdlInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CrdlInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CrdlInfoDlg.close = function () {
    parent.layer.close(window.parent.Crdl.layerIndex);
}

/**
 * 收集数据
 */
CrdlInfoDlg.collectData = function () {
    this
        .set('id')
        .set('name')
        .set('nowdate')
        .set('updatetime')
        .set('phone')
        .set('dictid')
        .set('dictname')
        .set('price1')
        .set('price2')
        .set('price3')
        .set('status')
        .set('message1');
}

/**
 * 提交添加
 */
CrdlInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/crdl/add", function (data) {
        Feng.success("添加成功!");
        window.parent.Crdl.table.refresh();
        CrdlInfoDlg.close();
    }, function (data) {
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.crdlInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CrdlInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/crdl/update", function (data) {
        Feng.success("修改成功!");
        window.parent.Crdl.table.refresh();
        CrdlInfoDlg.close();
    }, function (data) {
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.crdlInfoData);
    ajax.start();
}

$(function () {

});
