
import Vuex from 'vuex';
import register from '@/store/modules/register';
import CRUD from '@/store/modules/CRUD';
import classNav from '@/store/modules/classNav';
import login from '@/store/modules/login';
import global from '@/store/modules/global';


// 导入小模块的仓库。

export default new Vuex.Store({
	modules:{
		register,
		CRUD,
		classNav,
		login,
		global
	}
})
