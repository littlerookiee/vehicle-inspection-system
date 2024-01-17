<template>
	<div>
			<el-form-item v-if="$check_register_field('add','user_name','/maintaining_users/view')" label="用户姓名" prop="user_name">
				<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','user_gender','/maintaining_users/view')" label="用户性别" prop="user_gender">
				<el-select id="user_gender" v-model="form['user_gender']">
			<el-option v-for="o in list_user_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','user_phone_number','/maintaining_users/view')" label="用户电话" prop="user_phone_number">
				<el-input id="user_phone_number" v-model="form['user_phone_number']" placeholder="请输入用户电话" type="tel">
		</el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','id_number','/maintaining_users/view')" label="身份证号" prop="id_number">
				<el-input id="id_number" v-model="form['id_number']" placeholder="请输入身份证号"></el-input>
				</el-form-item>
	
	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
							"user_name":  '' ,
								"user_gender":  '' ,
								"user_phone_number":  '' ,
								"id_number":  '' ,
						}
				}
			},

		},
		data() {
			return {
				field: "maintaining_users_id",
				url_add: "~/api/maintaining_users/add?",
				url_set: "~/api/maintaining_users/set?",
				url_upload: "~/api/maintaining_users/upload?",

								list_user_gender: ['男','女'],
							rules: {
					"user_name": [    {required: true,message: '用户姓名不能为空'},  ],
					"user_gender": [    {required: true,message: '用户性别不能为空'},  ],
					"user_phone_number": [   {validator: this.$is_phone,trigger: 'blur'},   {required: true,message: '用户电话不能为空'},  ],
					"id_number": [    {required: true,message: '身份证号不能为空'},  ],
				}

			}
		},
		methods: {

	
	
	

	
	
	

	
	
	

	
	
	

		},
		created() {
						}
	}
</script>
