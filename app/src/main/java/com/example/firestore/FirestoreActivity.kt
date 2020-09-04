package com.example.firestore

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class FirestoreActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firestore_activity)
        initialize()
    }

    override fun onStop() {
        super.onStop()
        EventManager.unregister(this)
    }

    override fun onStart() {
        super.onStart()
        EventManager.register(this)
    }

    private fun initialize() {
        initLayout()
    }

    private fun initLayout() {
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ChatRoomsFragment())
            .commit()
    }

    private fun addChatRoomFragment(roomId: String, name: String) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, ChatRoomFragment().apply {
                arguments = Bundle().apply {
                    putString(ChatRoomFragment.KEY_ROOM_ID, roomId)
                    putString(ChatRoomFragment.KEY_ROOM_NAME, name)
                }
            })
            .addToBackStack(ChatRoomFragment::class.java.simpleName)
            .commit()
    }

    @Subscribe
    @Suppress("UNUSED")
    fun onEvent(event: EventManager.ClickChatRoomEvent) {
        addChatRoomFragment(event.roomId, event.name)
    }

    companion object {
        fun start(activity: Activity) = activity.startActivity(Intent(activity, FirestoreActivity::class.java))
    }
}