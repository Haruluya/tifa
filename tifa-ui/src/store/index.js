import app from '@/main.js';
import Vuex from 'vuex';
import optionsOne from '@/store/modules/optionsOne';
import optionTwo from '@/store/modules/optionTwo';



// 导入小模块的仓库。

export default new Vuex.Store({
	modules:{
		optionsOne,
		optionTwo
	}
})
