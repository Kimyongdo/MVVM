package com.example.simplifiedcoding_youtube_mvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.simplifiedcoding_youtube_mvvm.data.db.entities.User

@Database(
    entities = [User::class],//모든 entities를 여기에 정의
    version = 1 //버전
)//여러줄인줄 알았지만 하나의 줄 room이다보니 @을 쓰게 된 것
abstract class AppDatabase : RoomDatabase() {//RoomDatabase() 확장

    abstract fun getUserDao():UserDao//abstract class니까 함수도 abstract

    //실행순서가 class -> compaion obejct -> invoke자동실행
    companion object{
        @Volatile//아래 변수는 다른 쓰레드를 통해 즉시 보임-이거 더 찾아보기 ( )
        private var instance : AppDatabase?=null
        private val LOCk = Any()

        //abstract class AppDatabase 생성시 invoke함수 자동 호출
        operator fun invoke(context:Context)  = instance ?: synchronized(LOCk){//?
            instance?:buildDatabase(context).also {//also??
                   instance = it //instance : AppDatabase?에다가 데이터베이스를 생성해서 연결해줌
            }//null이었다면 데이터베이스 생성
        }

        private fun buildDatabase(context:Context)=//데이터베이스 만드는 코드
            Room.databaseBuilder(//room 3개의 파라미터
                context.applicationContext,//context
                AppDatabase::class.java,//AppDatabase : RoomDatabase() - 확장받음
                "MyDatabase.db"//이름
            ).build()//database를 return

    }
}