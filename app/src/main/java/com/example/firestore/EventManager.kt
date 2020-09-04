package com.example.firestore

import android.app.Activity

object EventManager {

    fun register(activity: Activity) {
        EventBus.getDefault().register(activity)
    }

    fun unregister(activity: Activity) {
        EventBus.getDefault().unregister(activity)
    }

    fun postClickChatRoomEvent(roomId: String, name: String) = postEvent(ClickChatRoomEvent(roomId, name))

    private fun postEvent(event: Any) = EventBus.getDefault().post(event)

    class ClickChatRoomEvent(val roomId: String, val name: String)
}
}