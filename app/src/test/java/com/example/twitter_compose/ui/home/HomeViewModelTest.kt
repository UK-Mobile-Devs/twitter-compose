package com.example.twitter_compose.ui.home

import com.example.twitter_compose.domain.model.TweetModel
import com.example.twitter_compose.domain.repo.HomeRepository
import com.nhaarman.mockitokotlin2.any
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class HomeViewModelTest {

    @MockK
    private lateinit var homeRepo: HomeRepository

    lateinit var sut: HomeViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)

        sut = HomeViewModelImpl(homeRepo)
    }

    @Test
    fun `when tweet list is empty return emptyList`() {
        every { homeRepo.getTweetList() } returns emptyList()

        val result = sut.getTweets()

        assertEquals(emptyList<TweetModel>(), result)
    }

    @Test
    fun `when tweet list received return all items`() {
        every { homeRepo.getTweetList() } returns listOf(any())

        val result = sut.getTweets()

        assertEquals(listOf<TweetModel>(any()), result)
    }

}
