<template>
    <div>
        <NavBar />
        <div class="box">
            <div class="filter-container">
                <el-input placeholder="合同号" v-model="pagination.contractId" style="width: 200px;" class="filter-item">
                </el-input>
                <el-input placeholder="类型" v-model="pagination.type" style="width: 200px;" class="filter-item">
                </el-input>
                <el-input placeholder="零售商" v-model="pagination.retailerId" style="width: 200px;" class="filter-item">
                </el-input>
                <el-button @click="getAll()" class="dalfBut">查询</el-button>
                <el-button type="primary" class="butT" @click="handleCreate()">添加</el-button>
            </div>
            <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>
                <el-table-column prop="contractId" align="center" label="序号"></el-table-column>
                <el-table-column prop="barcode" label="合同号" align="center"></el-table-column>
                <el-table-column prop="type" label="类型" align="center"></el-table-column>
                <el-table-column prop="retailerId" label="零售商序号" align="center"></el-table-column>
                <el-table-column prop="createTime" label="创建日期" align="center"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
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
                <el-dialog title="新增产品信息" :visible.sync="dialogFormVisible">
                    <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right"
                        label-width="100px">
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="姓名" prop="name">
                                    <el-input v-model="formData.name" />
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="价格" prop="price">
                                    <el-input v-model="formData.price" />
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="24">
                                <el-form-item label="产地">
                                    <el-input v-model="formData.locality" type="textarea"></el-input>
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
            <!-- 编辑标签弹层 -->
            <div class="add-form">
                <el-dialog title="编辑检查项" :visible.sync="dialogFormVisibleEdit">
                    <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right"
                        label-width="100px">
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
                        <el-row>
                            <el-col :span="23">
                                <el-form-item label="产地">
                                    <el-input v-model="formData.locality" type="textarea"></el-input>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="cancel()">取消</el-button>
                        <el-button type="primary" @click="handleEdit()">确定</el-button>
                    </div>
                </el-dialog>
            </div>
        </div>
    </div>
</template>
  
<script>
import NavBar from "../components/NavBar.vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap";

export default {
    name: 'ContractView',
    components: {
        NavBar,
    },

    data: function () {
        return {
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
                contractId: "",
                type: "",
                retailerId: "",
            }
        }
    },

    //钩子函数，VUE对象初始化完成后自动执行
    created() {
        //调用查询全部数据的操作
        this.getAll();
    },

    methods: {
        //条件查询与分页
        getAll() {
            console.log(this.formatDateValue(new Date()));
            //组织参数，拼接url请求地址
            //console.log("run");
            this.param = "?contractId=" + Number(this.pagination.contractId);
            this.param += "&type=" + this.pagination.type;
            this.param += "&retailerId=" + Number(this.pagination.retailerId);
            console.log(this.param);

            //发送异步请求
            this.axios.get("http://localhost:8888/contracts/" + this.pagination.currentPage + "/" + this.pagination.pageSize + this.param).then((res) => {
                // console.log(res.data);
                this.dataList = res.data.data.records;
                this.pagination.pageSize = res.data.data.size;
                this.pagination.currentPage = res.data.data.current;
                this.pagination.total = res.data.data.total;
                this.dataList = res.data.data.records;
            });
            // this.axios.get("http://localhost:8888/fruits/").then((res) => {
            //     console.log(res.data);
            //     this.dataList = res.data.data;
            // });
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
            this.axios.post("http://localhost:8888/contracts", this.formData).then((res) => {
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
                this.axios.delete("http://localhost:8888/contracts/" + row.contracts).then((res) => {
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

        // 弹出编辑窗口
        handleUpdate(row) {
            this.axios.get("http://localhost:8888/contracts/" + row.contractId).then((res) => {
                if (res.data.flag && res.data.data != null) {
                    this.dialogFormVisibleEdit = true;
                    this.formData = res.data.data;
                } else {
                    this.$message.error("数据同步失败，自动刷新");
                }
            }).finally(() => {
                //2.重新加载数据
                this.getAll();
            });
        },

        // 修改
        handleEdit() {
            this.axios.put("http://localhost:8888/contracts", this.formData).then((res) => {
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
    }
}
</script>