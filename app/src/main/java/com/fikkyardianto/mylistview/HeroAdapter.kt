package com.fikkyardianto.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return heroes.size
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }

}