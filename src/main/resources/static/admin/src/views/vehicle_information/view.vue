<template>
	<el-main class="bg edit_wrap comtable_e">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
		<el-row class="row_ce"> 
							<el-col v-if="user_group === '管理员' || $check_field('get','car_owner_account') || $check_field('add','car_owner_account') || $check_field('set','car_owner_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主账号" prop="car_owner_account">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_car_owner_account(form['car_owner_account']) }}
							<!--<el-input id="business_name" v-model="form['car_owner_account']" placeholder="请输入车主账号"-->
							<!--v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','car_owner_account')) || (!form['vehicle_information_id'] && $check_field('add','car_owner_account'))" :disabled="disabledObj['car_owner_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','car_owner_account')">{{form['car_owner_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','car_owner_account')) || (!form['vehicle_information_id'] && $check_field('add','car_owner_account'))" id="car_owner_account" v-model="form['car_owner_account']" :disabled="disabledObj['car_owner_account_isDisabled']">
								<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','car_owner_account')" id="car_owner_account" v-model="form['car_owner_account']" :disabled="true">
								<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="car_owner_account" v-model="form['car_owner_account']" :disabled="disabledObj['car_owner_account_isDisabled']">
							<el-option v-for="o in list_user_car_owner_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','owners_name') || $check_field('add','owners_name') || $check_field('set','owners_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主姓名" prop="owners_name">
												<el-input id="owners_name" v-model="form['owners_name']" placeholder="请输入车主姓名"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','owners_name')) || (!form['vehicle_information_id'] && $check_field('add','owners_name'))" :disabled="disabledObj['owners_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','owners_name')">{{form['owners_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_owner_gender') || $check_field('add','vehicle_owner_gender') || $check_field('set','vehicle_owner_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主性别" prop="vehicle_owner_gender">
												<el-input id="vehicle_owner_gender" v-model="form['vehicle_owner_gender']" placeholder="请输入车主性别"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','vehicle_owner_gender')) || (!form['vehicle_information_id'] && $check_field('add','vehicle_owner_gender'))" :disabled="disabledObj['vehicle_owner_gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_owner_gender')">{{form['vehicle_owner_gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','car_owners_phone_number') || $check_field('add','car_owners_phone_number') || $check_field('set','car_owners_phone_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车主电话" prop="car_owners_phone_number">
												<el-input id="car_owners_phone_number" v-model="form['car_owners_phone_number']" placeholder="请输入车主电话"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','car_owners_phone_number')) || (!form['vehicle_information_id'] && $check_field('add','car_owners_phone_number'))" :disabled="disabledObj['car_owners_phone_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','car_owners_phone_number')">{{form['car_owners_phone_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','id_number') || $check_field('add','id_number') || $check_field('set','id_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证号" prop="id_number">
												<el-input id="id_number" v-model="form['id_number']" placeholder="请输入身份证号"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','id_number')) || (!form['vehicle_information_id'] && $check_field('add','id_number'))" :disabled="disabledObj['id_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id_number')">{{form['id_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_model') || $check_field('add','vehicle_model') || $check_field('set','vehicle_model')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车辆车型" prop="vehicle_model">
												<el-input id="vehicle_model" v-model="form['vehicle_model']" placeholder="请输入车辆车型"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','vehicle_model')) || (!form['vehicle_information_id'] && $check_field('add','vehicle_model'))" :disabled="disabledObj['vehicle_model_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_model')">{{form['vehicle_model']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','license_plate_number') || $check_field('add','license_plate_number') || $check_field('set','license_plate_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车牌号码" prop="license_plate_number">
												<el-input id="license_plate_number" v-model="form['license_plate_number']" placeholder="请输入车牌号码"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','license_plate_number')) || (!form['vehicle_information_id'] && $check_field('add','license_plate_number'))" :disabled="disabledObj['license_plate_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','license_plate_number')">{{form['license_plate_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','vehicle_color') || $check_field('add','vehicle_color') || $check_field('set','vehicle_color')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车辆颜色" prop="vehicle_color">
												<el-input id="vehicle_color" v-model="form['vehicle_color']" placeholder="请输入车辆颜色"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','vehicle_color')) || (!form['vehicle_information_id'] && $check_field('add','vehicle_color'))" :disabled="disabledObj['vehicle_color_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','vehicle_color')">{{form['vehicle_color']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','engine_number') || $check_field('add','engine_number') || $check_field('set','engine_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="发动机号" prop="engine_number">
												<el-input id="engine_number" v-model="form['engine_number']" placeholder="请输入发动机号"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','engine_number')) || (!form['vehicle_information_id'] && $check_field('add','engine_number'))" :disabled="disabledObj['engine_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','engine_number')">{{form['engine_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','frame_number') || $check_field('add','frame_number') || $check_field('set','frame_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="车架号码" prop="frame_number">
												<el-input id="frame_number" v-model="form['frame_number']" placeholder="请输入车架号码"
							  v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','frame_number')) || (!form['vehicle_information_id'] && $check_field('add','frame_number'))" :disabled="disabledObj['frame_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','frame_number')">{{form['frame_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','driving_documents') || $check_field('add','driving_documents') || $check_field('set','driving_documents')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="驾驶证件" prop="driving_documents">
								<el-upload :disabled="disabledObj['driving_documents_isDisabled']" id="driving_documents" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_driving_documents"
						:show-file-list="false" v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','driving_documents')) || (!form['vehicle_information_id'] && $check_field('add','driving_documents'))">
						<img v-if="form['driving_documents']" :src="$fullUrl(form['driving_documents'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','driving_documents')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['driving_documents'])" :preview-src-list="[$fullUrl(form['driving_documents'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','other_remarks') || $check_field('add','other_remarks') || $check_field('set','other_remarks')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="其他备注" prop="other_remarks">
								<el-input type="textarea" id="other_remarks" v-model="form['other_remarks']" placeholder="请输入其他备注"
						v-if="user_group === '管理员' || (form['vehicle_information_id'] && $check_field('set','other_remarks')) || (!form['vehicle_information_id'] && $check_field('add','other_remarks'))" :disabled="disabledObj['other_remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','other_remarks')">{{form['other_remarks']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
		</el-row>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item v-if="$check_action('/vehicle_information/view','set') || $check_action('/vehicle_information/view','add') || $check_option('/vehicle_information/table','examine')">
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
				field: "vehicle_information_id",
				url_add: "~/api/vehicle_information/add?",
				url_set: "~/api/vehicle_information/set?",
				url_get_obj: "~/api/vehicle_information/get_obj?",
				url_upload: "~/api/vehicle_information/upload?",

				query: {
					"vehicle_information_id": 0,
				},

				form: {
								"car_owner_account": 0, // 车主账号
										"owners_name":  '', // 车主姓名
										"vehicle_owner_gender":  '', // 车主性别
										"car_owners_phone_number":  '', // 车主电话
										"id_number":  '', // 身份证号
										"vehicle_model":  '', // 车辆车型
										"license_plate_number":  '', // 车牌号码
										"vehicle_color":  '', // 车辆颜色
										"engine_number":  '', // 发动机号
										"frame_number":  '', // 车架号码
										"driving_documents":  '', // 驾驶证件
										"other_remarks":  '', // 其他备注
											"vehicle_information_id": 0, // ID
						
				},
				disabledObj:{
								"car_owner_account_isDisabled": false,
										"owners_name_isDisabled": false,
										"vehicle_owner_gender_isDisabled": false,
										"car_owners_phone_number_isDisabled": false,
										"id_number_isDisabled": false,
										"vehicle_model_isDisabled": false,
										"license_plate_number_isDisabled": false,
										"vehicle_color_isDisabled": false,
										"engine_number_isDisabled": false,
										"frame_number_isDisabled": false,
										"driving_documents_isDisabled": false,
										"other_remarks_isDisabled": false,
										},

	
					// 用户列表
				list_user_car_owner_account: [],
						// 用户组
				group_user_car_owner_account: "",
				
		
		
		
		
		
		
		
		
		
		
	
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
					/**
			 * 获取车主用户用户组
			 */
			async get_group_user_car_owner_account() {
							this.form["car_owner_account"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=车主用户");
				if(json.result && json.result.obj){
					this.group_user_car_owner_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_car_owner_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_car_owner_account.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["car_owner_account"] = id
									_this.disabledObj['car_owner_account' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "car_owner_account") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
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
			 * 上传驾驶证件
			 * @param {Object} param 图片参数
			 */
			upload_driving_documents(param){
						this.uploadFile(param.file, "driving_documents");
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
																												$.db.del("form");

				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
																																																

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
					bl = this.$check_action('/vehicle_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vehicle_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vehicle_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/vehicle_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/vehicle_information/view','get');
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
					this.get_group_user_car_owner_account();
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
