package com.example.btown.Home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.btown.Activity.LoginActivity
import com.example.btown.Board.BoardFragment
import com.example.btown.Category.CategoryFragment
import com.example.btown.Database.DatabaseModule
import com.example.btown.MyPage.MyPageFragment
import com.example.btown.Notification.NotificationFragment
import com.example.btown.R
import com.example.btown.user.UserEntity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import java.io.ByteArrayInputStream
import java.lang.Exception

class DetailFragment: Fragment(){
    private val boardDAO by lazy{
        DatabaseModule.getInstance(requireContext()).boardDAO()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val boardID = arguments?.getInt("boardID")?:kotlin.run { throw Error("There is not coincided ID") }

        boardDAO.getBoard(boardID).observe(viewLifecycleOwner, Observer {
            view.detailWriterID.setText(it.userID)
            view.detailContent.setText(it.boardContent)
            view.detailTime.setText(it.boardDate)
            view.detailType.setText(it.boardType)
            view.detailTitle.setText(it.boardTitle)
        })
    }

    fun byteArrayToBitmap(byteArray: ByteArray?): Bitmap {
        var byteArrayInputStream = ByteArrayInputStream(byteArray)
        var bitmap: Bitmap = BitmapFactory.decodeStream(byteArrayInputStream)

        return bitmap
    }
}