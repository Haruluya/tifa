
import Vuex from 'vuex';
import register from '@/store/modules/register';
import CRUD from '@/store/modules/CRUD';
import classNav from '@/store/modules/classNav';
import login from '@/store/modules/login';
import search from '@/store/modules/search'
import gooddetail from '@/store/modules/gooddetail';
import shopCart from '@/store/modules/shopCart';
// 导入小模块的仓库。

export default new Vuex.Store({
	modules:{
		register,
		CRUD,
		classNav,
		login,
		search,
		gooddetail,
		shopCart,
	}
})
