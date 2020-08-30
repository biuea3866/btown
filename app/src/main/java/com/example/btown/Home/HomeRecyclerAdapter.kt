package com.example.btown.Home

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.btown.Board.BoardEntity
import com.example.btown.Home.DetailActivity.Companion.BOARD_ID
import com.example.btown.R
import kotlinx.android.synthetic.main.list_board.view.*
import java.io.ByteArrayInputStream

class HomeRecyclcerAdapter(var boards: List<BoardEntity> = emptyList()):RecyclerView.Adapter<HomeRecyclcerAdapter.ItemViewHolder>() {
    override fun getItemCount() = boards.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        // TODO("Not yet implemented")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_board, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // TODO("Not yet implemented")
        holder.bindItems(boards[position])
    }

    inner class ItemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bindItems(board: BoardEntity){
            itemView.homeTitle.text = board.boardTitle
            itemView.homePrice.text = board.boardPrice
            itemView.homeType.text = board.boardCategory

            board.boardImage1.let{
                itemView.homeImg.visibility = View.VISIBLE

                itemView.homeImg.setImageBitmap(byteArrayToBitmap(it))
            } ?: kotlin.run {
                itemView.homeImg.visibility = View.GONE
            }

            itemView.setOnClickListener(){
                var intent = Intent(itemView.context, DetailActivity::class.java)

                intent.putExtra(BOARD_ID, board.boardID)
                itemView.context.startActivity(intent)
            }
        }
    }

    fun byteArrayToBitmap(byteArray: ByteArray?): Bitmap {
        var byteArrayInputStream = ByteArrayInputStream(byteArray)
        var bitmap: Bitmap = BitmapFactory.decodeStream(byteArrayInputStream)

        return bitmap
    }
}