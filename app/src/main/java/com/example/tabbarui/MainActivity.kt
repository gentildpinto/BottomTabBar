package com.example.tabbarui

import adapter.PagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import fragments.*

private const val CURRENT_ITEM = 0

class MainActivity : AppCompatActivity() {
    private lateinit var addBtn: ImageButton
    private lateinit var homeBtn: ImageButton
    private lateinit var searchBtn: ImageButton
    private lateinit var profileBtn: ImageButton
    private lateinit var notificationBtn: ImageButton

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn = findViewById(R.id.addBtn)
        homeBtn = findViewById(R.id.homeBtn)
        searchBtn = findViewById(R.id.searchBtn)
        profileBtn = findViewById(R.id.profileBtn)
        notificationBtn = findViewById(R.id.notificationBtn)

        viewPager = findViewById(R.id.viewPager)

        val pagerAdapter = PagerAdapter(supportFragmentManager, lifecycle).apply {
            addFragment(HomeFragment())
            addFragment(SearchFragment())
            addFragment(AddFragment())
            addFragment(NotificationFragment())
            addFragment(ProfileFragment())
        }

        viewPager.apply {
            adapter = pagerAdapter
            currentItem = CURRENT_ITEM

            registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    RecyclerView.OVER_SCROLL_NEVER.also {
                        (getChildAt(0) as RecyclerView).overScrollMode = it
                    }

                    changingTabs(position)
                }
            })
        }
    }

    private fun changingTabs(position: Int) {
        when (position) {
            0 -> {
                updateImageButton(
                    homeBtn,
                    R.drawable.ic_baseline_home_white,
                    R.drawable.roundcorner_shape
                )
                updateImageButton(searchBtn, R.drawable.ic_baseline_search)
                updateImageButton(addBtn, R.drawable.ic_baseline_add)
                updateImageButton(notificationBtn, R.drawable.ic_baseline_notifications_none)
                updateImageButton(profileBtn, R.drawable.ic_baseline_perm_identity)
            }
            1 -> {
                updateImageButton(homeBtn, R.drawable.ic_baseline_home)
                updateImageButton(
                    searchBtn,
                    R.drawable.ic_baseline_search_white,
                    R.drawable.roundcorner_shape
                )
                updateImageButton(addBtn, R.drawable.ic_baseline_add)
                updateImageButton(notificationBtn, R.drawable.ic_baseline_notifications_none)
                updateImageButton(profileBtn, R.drawable.ic_baseline_perm_identity)
            }
            2 -> {
                updateImageButton(homeBtn, R.drawable.ic_baseline_home)
                updateImageButton(searchBtn, R.drawable.ic_baseline_search)
                updateImageButton(
                    addBtn,
                    R.drawable.ic_baseline_add_white,
                    R.drawable.roundcorner_shape
                )
                updateImageButton(notificationBtn, R.drawable.ic_baseline_notifications_none)
                updateImageButton(profileBtn, R.drawable.ic_baseline_perm_identity)
            }
            3 -> {
                updateImageButton(homeBtn, R.drawable.ic_baseline_home)
                updateImageButton(searchBtn, R.drawable.ic_baseline_search)
                updateImageButton(addBtn, R.drawable.ic_baseline_add)
                updateImageButton(
                    notificationBtn,
                    R.drawable.ic_baseline_notifications_none_white,
                    R.drawable.roundcorner_shape
                )
                updateImageButton(profileBtn, R.drawable.ic_baseline_perm_identity)
            }
            4 -> {
                updateImageButton(homeBtn, R.drawable.ic_baseline_home)
                updateImageButton(searchBtn, R.drawable.ic_baseline_search)
                updateImageButton(addBtn, R.drawable.ic_baseline_add)
                updateImageButton(notificationBtn, R.drawable.ic_baseline_notifications_none)
                updateImageButton(
                    profileBtn,
                    R.drawable.ic_baseline_perm_identity_white,
                    R.drawable.roundcorner_shape
                )
            }
        }
    }

    private fun updateImageButton(
        buttonImage: ImageButton,
        resource: Int,
        backgroundShape: Int = R.color.white
    ) {
        buttonImage.apply {
            setImageResource(resource)
            setBackgroundResource(backgroundShape)
        }
    }
}