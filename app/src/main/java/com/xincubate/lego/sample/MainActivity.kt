package com.xincubate.lego.sample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.blankj.utilcode.util.ActivityUtils
import com.xincubate.lego.adapter.core.BaseAdapter
import com.xincubate.lego.adapter.core.BaseItem
import com.xincubate.lego.adapter.core.BaseViewHolder
import com.xincubate.lego.annotation.LegoItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(RecycleViewDivider(this, LinearLayoutManager.VERTICAL))


        val baseAdapter = BaseAdapter(this)
        baseAdapter.addItem(KindItem(this,"线性列表",1))
        baseAdapter.addItem(KindItem(this,"线性列表(包含Header和Footer)",2))
        baseAdapter.addItem(KindItem(this,"网格列表",3))
        baseAdapter.addItem(KindItem(this,"二级列表",4))
        baseAdapter.addItem(KindItem(this,"二级网格列表",5))
        baseAdapter.addItem(KindItem(this,"Bean列表",6))
        recyclerView.adapter = baseAdapter
    }

    @LegoItem
    class KindItem(context: Context,val title:String,val id:Int) : BaseItem(context) {

        override fun onBindViewHolder(viewHolder: BaseViewHolder, position: Int) {
            viewHolder.findViewById<TextView>(R.id.tv_title).text = title
        }

        override fun getLayoutId(): Int {
            return R.layout.listitem_kind
        }

        override fun onClick() {
            when(id){
                1 -> ActivityUtils.startActivity(ListActivity::class.java)
                2 -> ActivityUtils.startActivity(HeaderListActivity::class.java)
                3 -> ActivityUtils.startActivity(GridActivity::class.java)
                4 -> ActivityUtils.startActivity(GroupListActivity::class.java)
                5 -> ActivityUtils.startActivity(GroupGridActivity::class.java)
                6 -> ActivityUtils.startActivity(BeanListActivity::class.java)
            }
        }
    }
}
