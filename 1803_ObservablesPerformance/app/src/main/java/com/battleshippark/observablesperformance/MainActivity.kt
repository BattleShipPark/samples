package com.battleshippark.observablesperformance

import android.app.Activity
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import io.reactivex.subjects.BehaviorSubject as BehaviorSubject2
import io.reactivex.subjects.PublishSubject as PublishSubject2
import rx.subjects.BehaviorSubject as BehaviorSubject1
import rx.subjects.PublishSubject as PublishSubject1

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener {
            createInstance()
            subscribe()
            fire()
            fireTwice()
        }
    }

    private val COUNT = 5000

    fun createInstance() {
        stopWatch("RxJava1.BehaviorSubject") {
            val list: MutableList<BehaviorSubject1<Int>> = mutableListOf()
            for (i in 1..COUNT) {
                list.add(BehaviorSubject1.create())
            }
        }

        stopWatch("RxJava2.BehaviorSubject") {
            val list: MutableList<BehaviorSubject2<Int>> = mutableListOf()
            for (i in 1..COUNT) {
                list.add(BehaviorSubject2.create())
            }
        }

        stopWatch("RxJava1.PublishSubject") {
            val list: MutableList<PublishSubject1<Int>> = mutableListOf()
            for (i in 1..COUNT) {
                list.add(PublishSubject1.create())
            }
        }

        stopWatch("RxJava2.PublishSubject") {
            val list: MutableList<PublishSubject2<Int>> = mutableListOf()
            for (i in 1..COUNT) {
                list.add(PublishSubject2.create())
            }
        }

        stopWatch("LiveData") {
            val list: MutableList<LiveData<Int>> = mutableListOf()
            for (i in 1..COUNT) {
                list.add(MutableLiveData())
            }
        }
    }

    fun subscribe() {
        stopWatch("RxJava1.BehaviorSubject") {
            val subject: BehaviorSubject1<Int> = BehaviorSubject1.create()
            for (i in 1..COUNT) {
                subject.subscribe()
            }
        }

        stopWatch("RxJava2.BehaviorSubject") {
            val subject: BehaviorSubject2<Int> = BehaviorSubject2.create()
            for (i in 1..COUNT) {
                subject.subscribe()
            }
        }

        stopWatch("RxJava1.PublishSubject") {
            val subject: PublishSubject1<Int> = PublishSubject1.create()
            for (i in 1..COUNT) {
                subject.subscribe()
            }
        }

        stopWatch("RxJava2.PublishSubject") {
            val subject: PublishSubject2<Int> = PublishSubject2.create()
            for (i in 1..COUNT) {
                subject.subscribe()
            }
        }

        stopWatch("LiveData") {
            val subject: MutableLiveData<Int> = MutableLiveData()
            for (i in 1..COUNT) {
                subject.observeForever({})
            }
        }
    }

    fun fire() {
        run {
            val subject: BehaviorSubject1<Int> = BehaviorSubject1.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava1.BehaviorSubject") {
                subject.onNext(1)
            }
        }

        run {
            val subject: BehaviorSubject2<Int> = BehaviorSubject2.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava2.BehaviorSubject") {
                subject.onNext(1)
            }
        }

        run {
            val subject: PublishSubject1<Int> = PublishSubject1.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava1.PublishSubject") {
                subject.onNext(1)
            }
        }

        run {
            val subject: PublishSubject2<Int> = PublishSubject2.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava2.PublishSubject") {
                subject.onNext(1)
            }
        }

        run {
            val subject: MutableLiveData<Int> = MutableLiveData()
            for (i in 1..COUNT) {
                subject.observeForever({})
            }
            stopWatch("LiveData") {
                subject.postValue(1)
            }
        }
    }

    fun fireTwice() {
        run {
            val subject: BehaviorSubject1<Int> = BehaviorSubject1.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava1.BehaviorSubject") {
                subject.onNext(1)
                subject.onNext(1)
            }
        }

        run {
            val subject: BehaviorSubject2<Int> = BehaviorSubject2.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava2.BehaviorSubject") {
                subject.onNext(1)
                subject.onNext(1)
            }
        }

        run {
            val subject: PublishSubject1<Int> = PublishSubject1.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava1.PublishSubject") {
                subject.onNext(1)
                subject.onNext(1)
            }
        }

        run {
            val subject: PublishSubject2<Int> = PublishSubject2.create()
            for (i in 1..COUNT) {
                subject.subscribe({})
            }
            stopWatch("RxJava2.PublishSubject") {
                subject.onNext(1)
                subject.onNext(1)
            }
        }

        run {
            val subject: MutableLiveData<Int> = MutableLiveData()
            for (i in 1..COUNT) {
                subject.observeForever({})
            }
            stopWatch("LiveData") {
                subject.value = 1
                subject.value = 1
            }
        }
    }

    private inline fun stopWatch(msg: String, body: () -> Unit) {
        val start = System.currentTimeMillis()
        body()
        Log.i("Perf", msg + " " + (System.currentTimeMillis() - start))
    }
}
