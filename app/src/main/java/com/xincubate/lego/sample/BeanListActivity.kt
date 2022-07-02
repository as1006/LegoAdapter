package com.xincubate.lego.sample

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.xincubate.lego.adapter.bean.BaseBeanAdapter
import com.xincubate.lego.adapter.bean.ItemBuilder
import com.xincubate.lego.adapter.core.BaseItem
import com.xincubate.lego.adapter.core.BaseViewHolder
import com.xincubate.lego.annotation.LegoBean
import com.xincubate.lego.annotation.LegoItem
import com.xincubate.lego.layoutcenter.LayoutCenter
import kotlinx.android.synthetic.main.activity_main.*

class BeanListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        title = "Bean列表"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))

        val baseAdapter = BaseBeanAdapter(this)
        for (i in 1..100){
            baseAdapter.addBean(ListBean(i))
        }
        recyclerView.adapter = baseAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    @LegoBean(clazz = SimpleBeanListItem::class)
    data class ListBean(var index : Int)

    @LegoItem
    class SimpleBeanListItem(context: Context,val bean:ListBean) : BaseItem(context) {

        override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
            viewHolder.findViewById<TextView>(R.id.tv_title).text = "第${bean.index}条记录"
        }

        override fun getLayoutId(): Int {
            return R.layout.listitem_kind
        }

        override fun onClick() {

        }
    }
}
