package org.sopt.soptseminar_week1.data

data class FollowingListUserInfo(
    val userName: String
) {
    val userImageSrc = "https://github.com/$userName.png"
}