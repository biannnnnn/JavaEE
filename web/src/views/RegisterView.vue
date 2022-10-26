<template>
  <div id="poster">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="0px" label-position="left"
      class="register-container">
      <h3 class="register_title">
        系统注册
        <el-button @click="toLogin()">去登陆</el-button>
      </h3>
      <el-form-item label="" prop="username">
        <el-input type="text" v-model="ruleForm.username" placeholder="请输入用户名" prefix-icon="el-icon-user-solid">
        </el-input>
      </el-form-item>
      <el-form-item label="" prop="password">
        <el-input type="password" v-model="ruleForm.password" autocomplete="off" placeholder="请输入密码"
          prefix-icon="el-icon-lock"></el-input>
      </el-form-item>
      <el-form-item label="" prop="checkPassword">
        <el-input type="password" v-model="ruleForm.checkPassword" autocomplete="off" placeholder="请确认密码"
          prefix-icon="el-icon-lock"></el-input>
      </el-form-item>
      <el-form-item label="" prop="name">
        <el-input type="text" v-model="ruleForm.name" placeholder="请输入姓名" prefix-icon="el-icon-user-solid"></el-input>
      </el-form-item>
      <el-form-item label="" prop="telephone">
        <el-input type="text" v-model.number="ruleForm.telephone" placeholder="请输入电话" prefix-icon="el-icon-phone">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleForm)">注册</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style>
#poster {
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;

  margin: 0px;
  padding: 0px;
}

.register-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 300px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.register_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>

<script>
export default {
  name: 'RegisterView',

  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPassword !== '') {
          this.$refs.ruleForm.validateField('checkPassword');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        username: '',
        password: '',
        checkPassword: '',
        name: '',
        telephone: ''
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: 'blur' },
        ],
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPassword: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        name: [
          { required: true, message: "请输入姓名", trigger: 'blur' },
        ],
        telephone: [
          { required: true, message: "请输入电话号码", trigger: 'blur' },
        ]
      }
    };
  },
  methods: {
    submitForm() {
      this.axios.post('http://localhost:8888/user/register', this.ruleForm).then((resp) => {
        console.log(resp);
        let data = resp.data;
        console.log(data);
        if (data.success) {
          this.ruleForm = {};
          this.$message({
            message: '恭喜你，注册成功，点击登录按钮进行登陆',
            type: 'success'
          });
          this.$router.push({path:'/'})
        } else {
          this.$message({
            message: '对不起，您注册的用户已存在，请重新注册',
            type: 'error'
          });
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    toLogin() {
      this.$router.push({ path: '/' })
    }
  }
}
</script>
  