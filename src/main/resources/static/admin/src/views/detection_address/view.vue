<template>
	<el-main class="bg edit_wrap comtable_e">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
		<el-row class="row_ce"> 
							<el-col v-if="user_group === '管理员' || $check_field('get','store_name') || $check_field('add','store_name') || $check_field('set','store_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺名称" prop="store_name">
												<el-input id="store_name" v-model="form['store_name']" placeholder="请输入店铺名称"
							  v-if="user_group === '管理员' || (form['detection_address_id'] && $check_field('set','store_name')) || (!form['detection_address_id'] && $check_field('add','store_name'))" :disabled="disabledObj['store_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_name')">{{form['store_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_image') || $check_field('add','store_image') || $check_field('set','store_image')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺图片" prop="store_image">
								<el-upload :disabled="disabledObj['store_image_isDisabled']" id="store_image" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_store_image"
						:show-file-list="false" v-if="user_group === '管理员' || (form['detection_address_id'] && $check_field('set','store_image')) || (!form['detection_address_id'] && $check_field('add','store_image'))">
						<img v-if="form['store_image']" :src="$fullUrl(form['store_image'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','store_image')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['store_image'])" :preview-src-list="[$fullUrl(form['store_image'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','detection_address') || $check_field('add','detection_address') || $check_field('set','detection_address')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测地址" prop="detection_address">
												<el-input id="detection_address" v-model="form['detection_address']" placeholder="请输入检测地址"
							  v-if="user_group === '管理员' || (form['detection_address_id'] && $check_field('set','detection_address')) || (!form['detection_address_id'] && $check_field('add','detection_address'))" :disabled="disabledObj['detection_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','detection_address')">{{form['detection_address']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','testing_prices') || $check_field('add','testing_prices') || $check_field('set','testing_prices')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测价格" prop="testing_prices">
								<el-input-number id="testing_prices" v-model.number="form['testing_prices']"
						v-if="user_group === '管理员' || (form['detection_address_id'] && $check_field('set','testing_prices')) || (!form['detection_address_id'] && $check_field('add','testing_prices'))" :disabled="disabledObj['testing_prices_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','testing_prices')">{{form['testing_prices']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','available_time_for_scheduling') || $check_field('add','available_time_for_scheduling') || $check_field('set','available_time_for_scheduling')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="可约时间" prop="available_time_for_scheduling">
								<el-date-picker :disabled="disabledObj['available_time_for_scheduling_isDisabled']" v-if="user_group === '管理员' || (form['detection_address_id'] && $check_field('set','available_time_for_scheduling')) || (!form['detection_address_id'] && $check_field('add','available_time_for_scheduling'))" id="available_time_for_scheduling"
						v-model="form['available_time_for_scheduling']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','available_time_for_scheduling')">{{form['available_time_for_scheduling']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','testing_items') || $check_field('add','testing_items') || $check_field('set','testing_items')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="检测项目" prop="testing_items">
								<el-input type="textarea" id="testing_items" v-model="form['testing_items']" placeholder="请输入检测项目"
						v-if="user_group === '管理员' || (form['detection_address_id'] && $check_field('set','testing_items')) || (!form['detection_address_id'] && $check_field('add','testing_items'))" :disabled="disabledObj['testing_items_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','testing_items')">{{form['testing_items']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
		</el-row>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item v-if="$check_action('/detection_address/view','set') || $check_action('/detection_address/view','add') || $check_option('/detection_address/table','examine')">
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
				field: "detection_address_id",
				url_add: "~/api/detection_address/add?",
				url_set: "~/api/detection_address/set?",
				url_get_obj: "~/api/detection_address/get_obj?",
				url_upload: "~/api/detection_address/upload?",

				query: {
					"detection_address_id": 0,
				},

				form: {
								"store_name":  '', // 店铺名称
										"store_image":  '', // 店铺图片
										"detection_address":  '', // 检测地址
										"testing_prices":  0, // 检测价格
										"available_time_for_scheduling":  '', // 可约时间
										"testing_items":  '', // 检测项目
											"detection_address_id": 0, // ID
						
				},
				disabledObj:{
								"store_name_isDisabled": false,
										"store_image_isDisabled": false,
										"detection_address_isDisabled": false,
					          			"testing_prices_isDisabled": false,
										"available_time_for_scheduling_isDisabled": false,
										"testing_items_isDisabled": false,
										},

	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
						/**
			 * 上传店铺图片
			 * @param {Object} param 图片参数
			 */
			upload_store_image(param){
						this.uploadFile(param.file, "store_image");
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
									        if (this.form["available_time_for_scheduling"] && this.form["available_time_for_scheduling"].indexOf("-")===-1){
            this.form["available_time_for_scheduling"] = this.$toTime(parseInt(this.form["available_time_for_scheduling"]),"yyyy-MM-dd hh:mm:ss")
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
																					if(this.form["available_time_for_scheduling"]=="0000-00-00 00:00:00"){
				  this.form["available_time_for_scheduling"] = null;
				}
				if(parseInt(this.form["available_time_for_scheduling"]) > 9999){
					this.form["available_time_for_scheduling"] = this.$toTime(parseInt(this.form["available_time_for_scheduling"]),"yyyy-MM-dd hh:mm:ss")
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
					bl = this.$check_action('/detection_address/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/detection_address/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/detection_address/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/detection_address/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/detection_address/view','get');
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
