<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title></title>
    <tag:header/>
</head>
<body id="main_layout">
<div class="winContainer">

    <form id="formMain">
        <div class="headerTable"></div>
    </form>
</div>
</body>
</html>
<script type="text/template" id="headerTmpl">

    <div>
        <div class="col">
            <div class="td">
                <input id="userName" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="realName" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <select id="sex" style="width: 80px" class="easyui-combobox widget"
                        data-options="editable:false">
                    <option value="1">男</option>
                    <option value="0">女</option>
                </select>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="rolesName" class="widget" >
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="sysDepartmentName" class="widget"/>

            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="empNo" type="text" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="email" class="widget" data-options="required:false,validType:'email'" type="text"/></div>
        </div>
        <div class="col">
            <div class="td">
                <input id="cellphone" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="phone" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="structureIds"
                       class="easyui-combotree widget"
                       data-options="valueField:'id',textField:'name',url:'${pageContext.request.contextPath}/api/ebp/sysstructure/gettree',required:false,multiple:true">
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="addTime" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="addBy" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="editTime" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <input id="editBy" class="widget"/>
            </div>
        </div>
        <div class="col">
            <div class="td">
                <textarea id="remark" class="widget"></textarea>
            </div>
        </div>
    </div>
</script>
<script type="text/javascript">
    $(function () {
        /*表单数据加载成功的事件处理函数*/
        function onFormLoadSuccess(data) {
            if(data.id){
                var userId = data.id;
//                loadUserRoles(userId);
                loadUserStuctures(userId);
            }
        }
        function loadUserRoles(userId) {
            $.ajax({
                url: '${pageContext.request.contextPath}/api/ebp/syspermission/getuserroles?userId='+userId,
                method: 'GET',
                cache: false
            }).success(
                    function (result) {
                        var roleIds = [];
                        $.each(result.data, function (index, value) {
                            roleIds.push(value.id)
                        });
                        $('#roleIds').combobox('setValues', roleIds);
                    }
            );
        }

        function loadUserStuctures(userId) {
            $.ajax({
                url: '${pageContext.request.contextPath}/api/ebp/sysstructure/getuserstructures?userId='+userId,
                method: 'GET',
                cache: false
            }).success(
                    function (result) {
                        var ids = [];
                        $.each(result.data, function (index, value) {
                            ids.push(value.id)
                        });
                        $('#structureIds').combotree('setValues', ids);
                    }
            );
        }

        //构造pageform（主数据）
        var easyUIFormParams = {onLoadSuccess: onFormLoadSuccess};
        var url = '${pageContext.request.contextPath}/api/${modulePath}';
        var pageForm = new PageForm('formMain', url, easyUIFormParams, null, function (data) {
            //主数据请求完后同时得到其子数据，渲染子数据
        }, null, 'edit');
        //初始化表单
        function initForm() {
            pageForm.init().loadForm();
            $('#btnSave').on('click', function () {
                pageForm.submitForm();
            });
        }

        PageForm.prepareFormWidget($('.headerTable'), $($('#headerTmpl').html()), '${pageContext.request.contextPath}', '${modulePath}', 'detail', initForm);

    });

</script>
