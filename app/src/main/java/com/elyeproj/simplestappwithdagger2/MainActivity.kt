package com.elyeproj.simplestappwithdagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMagicBox.create().poke(this)
        text_view.text = info.text
    }
}

@Module
class Bag {
    @Provides
    fun sayLoveDagger2(): Info {
        return Info("Love Dagger 2")
    }
}

class Info(val text: String)

@Component(modules = [Bag::class])
interface MagicBox {
    fun poke(app: MainActivity)
}
