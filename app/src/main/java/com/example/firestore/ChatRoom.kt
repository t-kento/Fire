package com.example.firestore

import java.util.*

class ChatRoom {
    var name: String = ""
    var roomId: String = "${System.currentTimeMillis()}"
    var createdAt: Date = Date()
}