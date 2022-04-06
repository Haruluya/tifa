import app from '@/main.js';
import Vuex from 'vuex';
import optionsOne from '@/store/modules/optionsOne';
import optionTwo from '@/store/modules/optionTwo';
import register from '@/store/modules/register';
import CRUD from '@/store/modules/CRUD';


// 导入小模块的仓库。

export default new Vuex.Store({
	modules:{
		optionsOne,
		optionTwo,
		register,
		CRUD
	}
})
