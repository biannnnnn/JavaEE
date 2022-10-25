<template>
    <!--1.首先，弹窗页面中要有el-dialog组件即弹窗组件，我们把弹窗中的内容放在el-dialog组件中-->
    <!--2.设置:visible.sync属性，动态绑定一个布尔值，通过这个属性来控制弹窗是否弹出-->
    <el-dialog title="附属品信息" :visible.sync="detailVisible" width="35%">
        <div class="box">
            <div class="filter-container">
                <!-- <el-button @click="getAll()" class="dalfBut">查询</el-button> -->
                <el-button type="primary" class="butT" @click="handleCreate()">添加</el-button>
            </div>
            <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>
                <el-table-column prop="name" label="名称" align="center"></el-table-column>
                <el-table-column prop="price" label="价格" align="center"></el-table-column>
                <el-table-column prop="createTime" label="创建日期" align="center"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--分页组件-->
            <div class="pagination-container">
                <el-pagination class="pagiantion" @current-change="handleCurrentChange"
                    :current-page="pagination.currentPage" :page-size="pagination.pageSize"
                    layout="total, prev, pager, next, jumper" :total="pagination.total">
                </el-pagination>
            </div>
            <!-- 新增标签弹层 -->
            <div class="add-form">
                <el-dialog title="新增附属品信息" :visible.sync="dialogFormVisible">
                    <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right"
                        label-width="50px">
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="名称" prop="name">
                                    <el-input v-model="formData.name" />
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="价格" prop="price">
                                    <el-input v-model="formData.price" />
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="cancel()">取消</el-button>
                        <el-button type="primary" @click="handleAdd()">确定</el-button>
                    </div>
                </el-dialog>
            </div>
        </div>
    </el-dialog>
</template>
    
<script>
export default {
    name: "AccessoryView",
    data() {
        return {
            detailVisible: false,
            dataList: [],//当前页要展示的列表数据
            dialogFormVisible: false,//添加表单是否可见
            dialogFormVisibleEdit: false,//编辑表单是否可见
            formData: {},//表单数据
            rules: {},
            Visiable: false,
            pagination: {//分页相关模型数据
                currentPage: 1,//当前页码
                pageSize: 10,//每页显示的记录数
                total: 0,//总记录数
                name: "",
                price: "",
                locality: ""
            }
        }
    },

    //钩子函数，VUE对象初始化完成后自动执行
    created() {
        //调用查询全部数据的操作
        this.getAll();
    },

    methods: {
        //3.定义一个init函数，通过设置detailVisible值为true来让弹窗弹出，这个函数会在父组件的方法中被调用
        init(data) {
            this.detailVisible = true;
            //data是父组件弹窗传递过来的值，我们可以打印看看
            console.log(data);
        },

        //条件查询与分页
        getAll() {
            this.axios.get("http://localhost:8888/accessory/").then((res) => {
                console.log(res.data);
                this.dataList = res.data.data;
            });
        },

        //切换页码
        handleCurrentChange(currentPage) {
            //修改页码值为当前选中的页码值
            this.pagination.currentPage = currentPage;
            //执行查询
            this.getAll();
        },

        //弹出添加窗口
        handleCreate() {
            this.dialogFormVisible = true;
            this.resetForm();
        },

        //重置表单
        resetForm() {
            this.formData = {};
        },

        // 添加
        handleAdd() {
            this.formData.status = 1;
            this.formData.createTime = this.formatDateValue(new Date());
            this.axios.post("http://localhost:8888/accessory", this.formData).then((res) => {
                // 判断当前操作是否成功
                if (res.data.flag) {
                    // 1.关闭弹层
                    this.dialogFormVisible = false;
                    this.$message.success("添加信息成功！");
                } else {
                    this.$message.error("添加信息失败");
                }
            }).finally(() => {
                // 2.重新加载数据
                this.getAll();
            });
        },

        // 取消
        cancel() {
            this.dialogFormVisible = false;
            this.dialogFormVisibleEdit = false;
            this.$message.info("当前操作取消");
        },

        // 删除
        handleDelete(row) {
            // console.log(row);
            this.$confirm("此操作永久删除当前信息，是否继续？", "提示", { type: "info" }).then(() => {
                this.axios.delete("http://localhost:8888/accessory/" + row.fruitId).then((res) => {
                    if (res.data.flag) {
                        this.$message.success("删除成功");
                    } else {
                        this.$message.error("数据同步失败，自动刷新");
                    }
                }).finally(() => {
                    // 2.重新加载数据
                    this.getAll();
                });
            }).catch(() => {
                this.$message.info("取消操作");
            });
        },

        // 修改
        handleEdit() {
            this.axios.put("http://localhost:8888/accessory", this.formData).then((res) => {
                // 判断当前操作是否成功
                if (res.data.flag) {
                    // 1.关闭弹层
                    this.dialogFormVisibleEdit = false;
                    this.$message.success("修改成功");
                } else {
                    this.$message.error("修改失败");
                }
            }).finally(() => {
                // 2.重新加载数据
                this.getAll();
            });
        },

        // 给后端发送日期格式
        formatDateValue(now) {
            var year = this.dateZero(now.getFullYear()); //取得4位数的年份
            var month = this.dateZero(now.getMonth() + 1); //取得日期中的月份，其中0表示1月，11表示12月
            var date = this.dateZero(now.getDate()); //返回日期月份中的天数（1到31）
            var hour = this.dateZero(now.getHours()); //返回日期中的小时数（0到23）
            var minute = this.dateZero(now.getMinutes()); //返回日期中的分钟数（0到59）
            var second = this.dateZero(now.getSeconds()); //返回日期中的秒数（0到59）
            return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
        },

        // 日期前面加0
        dateZero(time) {
            if (time < 10) {
                time = "" + "0" + time;
            }
            return time;
        },

        // 弹窗界面
        handleClick(data) {
            this.Visiable = true;
            this.$nextTick(() => {
                //这里的dialog与上面dialog-component组件里面的ref属性值是一致的
                //init调用的是dialog-component组件里面的init方法
                //data是传递给弹窗页面的值
                this.$refs.dialog.init(data);
            })
        },
    }
}
</script>
    