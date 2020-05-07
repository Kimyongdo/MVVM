package com.example.simplifiedcoding_youtube_mvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.simplifiedcoding_youtube_mvvm.data.db.entities.CURRENT_USER_ID
import com.example.simplifiedcoding_youtube_mvvm.data.db.entities.User

@Dao //room 라이브러리사용
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)//conflict이 난다면 새로 들어온 것으로 덮어씌우기
    fun upsert(user:User):Long//entities user가져옴, upsert = up +insert

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")//user테이블, uid가 CURRENT_USER_ID
    fun getUser() : LiveData<User>
}