<template>
	<el-main class="bg edit_wrap comtable_e">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
		<el-row class="row_ce"> 
							<el-col v-if="user_group === '管理员' || $check_field('get','car_owner_account') || $check_field('add','car_owner_account') || $check_field('set','car_owner_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主账号" prop="car_owner_account">
													<el-select v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','car_owner_account')) || (!form['message_notification_id'] && $check_field('add','car_owner_account'))" id="car_owner_account" v-model="form['car_owner_account']" :disabled="disabledObj['car_owner_account_isDisabled']">
							<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','car_owner_account')" id="car_owner_account" v-model="form['car_owner_account']" :disabled="true">
							<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','owners_name') || $check_field('add','owners_name') || $check_field('set','owners_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主姓名" prop="owners_name">
								<el-select id="owners_name" v-model="form['owners_name']" @change="select_owners_name_field"						v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','owners_name')) || (!form['message_notification_id'] && $check_field('add','owners_name'))">
						<el-option v-for="o in list_owners_name" :key="o['owners_name']" :label="o['owners_name']"
							:value="o['owners_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','owners_name')">{{form['owners_name']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_owner_gender') || $check_field('add','vehicle_owner_gender') || $check_field('set','vehicle_owner_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主性别" prop="vehicle_owner_gender">
								<el-input id="vehicle_owner_gender" v-model="form['vehicle_owner_gender']"
						v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','vehicle_owner_gender')) || (!form['message_notification_id'] && $check_field('add','vehicle_owner_gender'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','vehicle_owner_gender')">{{form['vehicle_owner_gender']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','car_owners_phone_number') || $check_field('add','car_owners_phone_number') || $check_field('set','car_owners_phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主电话" prop="car_owners_phone_number">
								<el-input id="car_owners_phone_number" v-model="form['car_owners_phone_number']"
						v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','car_owners_phone_number')) || (!form['message_notification_id'] && $check_field('add','car_owners_phone_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','car_owners_phone_number')">{{form['car_owners_phone_number']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','id_number') || $check_field('add','id_number') || $check_field('set','id_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证号" prop="id_number">
								<el-input id="id_number" v-model="form['id_number']"
						v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','id_number')) || (!form['message_notification_id'] && $check_field('add','id_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','id_number')">{{form['id_number']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','notification_date') || $check_field('add','notification_date') || $check_field('set','notification_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知日期" prop="notification_date">
								<el-date-picker :disabled="disabledObj['notification_date_isDisabled']" v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','notification_date')) || (!form['message_notification_id'] && $check_field('add','notification_date'))" id="notification_date"
						v-model="form['notification_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','notification_date')">{{form['notification_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','notification_content') || $check_field('add','notification_content') || $check_field('set','notification_content')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="通知内容" prop="notification_content">
								<el-input type="textarea" id="notification_content" v-model="form['notification_content']" placeholder="请输入通知内容"
						v-if="user_group === '管理员' || (form['message_notification_id'] && $check_field('set','notification_content')) || (!form['message_notification_id'] && $check_field('add','notification_content'))" :disabled="disabledObj['notification_content_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','notification_content')">{{form['notification_content']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
		</el-row>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item v-if="$check_action('/message_notification/view','set') || $check_action('/message_notification/view','add') || $check_option('/message_notification/table','examine')">
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
				<el-form-item v-else>
					<el-button @click="cancel()">返回</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "message_notification_id",
				url_add: "~/api/message_notification/add?",
				url_set: "~/api/message_notification/set?",
				url_get_obj: "~/api/message_notification/get_obj?",
				url_upload: "~/api/message_notification/upload?",

				query: {
					"message_notification_id": 0,
				},

				form: {
								"car_owner_account": 0, // 车主账号
										"owners_name":  '', // 车主姓名
										"vehicle_owner_gender":  '', // 车主性别
										"car_owners_phone_number":  '', // 车主电话
										"id_number":  '', // 身份证号
										"notification_date":  '', // 通知日期
										"notification_content":  '', // 通知内容
											"message_notification_id": 0, // ID
						
				},
				disabledObj:{
								"car_owner_account_isDisabled": false,
										"owners_name_isDisabled": false,
										"vehicle_owner_gender_isDisabled": false,
										"car_owners_phone_number_isDisabled": false,
										"id_number_isDisabled": false,
										"notification_date_isDisabled": false,
										"notification_content_isDisabled": false,
										},

	
					// 用户列表
				list_user_car_owner_account: [],
										// 车主姓名选项列表
				list_owners_name: [""],
	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取车主用户用户列表
			 */
			async get_list_user_car_owner_account() {
                // if(this.user_group !== "管理员" && this.form["car_owner_account"] === 0) {
                //     this.form["car_owner_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=车主用户");
                if(json.result && json.result.list){
                    this.list_user_car_owner_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_car_owner_account(id){
				var obj = this.list_user_car_owner_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
				/**
			 * 获取车主姓名列表
			 */
			async get_list_owners_name() {
				var json = await this.$get("~/api/car_owners_and_users/get_list?");
				if(json.result && json.result.list){
					this.list_owners_name = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
					select_owners_name_field(v){
				this.$get('~/api/car_owners_and_users/get_obj?owners_name='+v,{},(res)=>{
					if(res.result && res.result.obj){
																																this.form.vehicle_owner_gender = res.result.obj.vehicle_owner_gender;
																											this.form.car_owners_phone_number = res.result.obj.car_owners_phone_number;
																											this.form.id_number = res.result.obj.id_number;
																															}else{
						console.error(res.error);
					}
				})
			},
					
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																						
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
												        if (this.form["notification_date"] && this.form["notification_date"].indexOf("-")===-1){
          this.form["notification_date"] = this.$toTime(parseInt(this.form["notification_date"]),"yyyy-MM-dd")
        }
							$.db.del("form");

				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
																										if(this.form["notification_date"]=="0000-00-00"){
				  this.form["notification_date"] = null;
				}
				if(parseInt(this.form["notification_date"]) > 9999){
					this.form["notification_date"] = this.$toTime(parseInt(this.form["notification_date"]),"yyyy-MM-dd")
				}
							

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
																																																																					return null;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/message_notification/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/message_notification/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/message_notification/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/message_notification/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/message_notification/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_car_owner_account();
							this.get_list_owners_name();
														},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
