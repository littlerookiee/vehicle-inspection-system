<template>
	<div>
			<el-form-item v-if="$check_register_field('add','owners_name','/car_owners_and_users/view')" label="车主姓名" prop="owners_name">
				<el-input id="owners_name" v-model="form['owners_name']" placeholder="请输入车主姓名"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','vehicle_owner_gender','/car_owners_and_users/view')" label="车主性别" prop="vehicle_owner_gender">
				<el-select id="vehicle_owner_gender" v-model="form['vehicle_owner_gender']">
			<el-option v-for="o in list_vehicle_owner_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','car_owners_phone_number','/car_owners_and_users/view')" label="车主电话" prop="car_owners_phone_number">
				<el-input id="car_owners_phone_number" v-model="form['car_owners_phone_number']" placeholder="请输入车主电话" type="tel">
		</el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','id_number','/car_owners_and_users/view')" label="身份证号" prop="id_number">
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
							"owners_name":  '' ,
								"vehicle_owner_gender":  '' ,
								"car_owners_phone_number":  '' ,
								"id_number":  '' ,
						}
				}
			},

		},
		data() {
			return {
				field: "car_owners_and_users_id",
				url_add: "~/api/car_owners_and_users/add?",
				url_set: "~/api/car_owners_and_users/set?",
				url_upload: "~/api/car_owners_and_users/upload?",

								list_vehicle_owner_gender: ['男','女'],
							rules: {
					"owners_name": [    {required: true,message: '车主姓名不能为空'},  ],
					"vehicle_owner_gender": [    {required: true,message: '车主性别不能为空'},  ],
					"car_owners_phone_number": [   {validator: this.$is_phone,trigger: 'blur'},   {required: true,message: '车主电话不能为空'},  ],
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
