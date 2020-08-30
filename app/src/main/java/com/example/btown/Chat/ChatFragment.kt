package com.example.btown.Chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btown.Database.DatabaseModule
import com.example.btown.Home.HomeRecyclerAdapter
import com.example.btown.R
import kotlinx.android.synthetic.main.fragment_chat.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class ChatFragment : Fragment(){
    val chatDAO by lazy { DatabaseModule.getInstance(requireContext()).chatDAO() }
    val chatAdapter = ChatRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_chat, container, false)

        rootView.recycleChat.adapter = chatAdapter
        rootView.recycleChat.layoutManager = LinearLayoutManager(requireContext())

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chatDAO.getLiveChat().observe(viewLifecycleOwner, Observer {
            chatAdapter.chats = it
            chatAdapter.notifyDataSetChanged()
        })
    }

    override fun onStart() {
        super.onStart()
    }
}