<template>
  <div class="pagination">
    <!-- 上 -->
    <button :disabled="currentPageIndex == 1" @click="$emit('skipToClickPage', currentPageIndex - 1)">
      上一页
    </button>
    <button
      v-if="beginAndEndPageIndex.begin > 1"
      @click="$emit('skipToClickPage', 1)"
      :class="{ active: currentPageIndex == 1 }"
    >
      1
    </button>
    <button v-if="beginAndEndPageIndex.begin > 2">···</button>
    <!-- 中间部分 -->
    <span v-for="page in 33" :key="page">
        <button
        v-if="page >= beginAndEndPageIndex.begin"
        @click="$emit('skipToClickPage', page)"
        :class="{ active: currentPageIndex == page }"
        >
            {{ page }}
        </button>
    </span>


    <!-- 下 -->
    <button v-if="beginAndEndPageIndex.end < totalPageAmount - 1">···</button>
    <button
      v-if="beginAndEndPageIndex.end < totalPageAmount"
      @click="$emit('skipToClickPage', totalPageAmount)"
      :class="{active:currentPageIndex==totalPageAmount}"
    >
      {{ totalPageAmount }}
    </button>
    <button
      :disabled="currentPageIndex == totalPageAmount"
      @click="$emit('skipToClickPage', currentPageIndex + 1)"
    >
      下一页
    </button>

    <button style="margin-left: 30px">共 {{ totalItemAmount }} 条</button>
  </div>
</template>

<script>
export default {
    name: "PageHelper",
    props: ["currentPageIndex", "onePageItemAmount", "totalItemAmount", "pageSize"],
    computed: {

        //总页数。
        totalPageAmount() {
        return Math.ceil(this.totalItemAmount / this.onePageItemAmount);
        },

        //页面起始和结束页数。
        beginAndEndPageIndex(){
            const { pageSize, currentPageIndex, totalPageAmount } = this;
            let begin = 0, end = 0;
        
            //总页数不够展示。
            if (pageSize > totalPageAmount) {
                begin = 1;  end = totalPageAmount;
            } else {
                begin = currentPageIndex - parseInt(pageSize / 2);
                end = currentPageIndex + parseInt(pageSize / 2);
                
                //当前页太小无法居中。
                if (begin < 1) {
                    begin = 1;  end = pageSize;
                }

                //当前页太大居中。
                if (end > totalPageAmount) {
                    end = totalPageAmount;
                    begin = totalPageAmount - pageSize + 1;
                }
            }
            return { begin, end };
        },


    },
};
</script>

<style lang="less" scoped>
.pagination {
  text-align: center;
  button {
    margin: 0 5px;
    background-color: white;
    color: #606266;
    outline: none;
    border-radius: 2px;
    padding: 0 4px;
    vertical-align: top;
    display: inline-block;
    font-size: 13px;
    min-width: 35.5px;
    height: 28px;
    line-height: 28px;
    cursor: pointer;
    box-sizing: border-box;
    text-align: center;
    border: 0;

    &[disabled] {
      color: #c0c4cc;
      cursor: not-allowed;
    }

    &.active {
      cursor: not-allowed;
      background-color: #409eff;
      color: #fff;
    }
  }
}
.active{
  background: skyblue;
}
</style>
