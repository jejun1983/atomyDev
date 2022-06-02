package m.com.atomy.utils

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import m.com.atomy.activity.MainActivity


fun getIconBadgeIntent(context: Context, notiCnt: Int): PendingIntent {
    val badgeIntent = Intent("android.intent.action.BADGE_COUNT_UPDATE")
    badgeIntent.putExtra("badge_count", notiCnt)
    badgeIntent.putExtra("badge_count_package_name", context.packageName)
    badgeIntent.putExtra("badge_count_class_name", MainActivity::class.java.name)

    return PendingIntent.getBroadcast(context, 0 /* Request code */, badgeIntent, PendingIntent.FLAG_ONE_SHOT)
}

fun setIconBadge(context: Context, notiCnt: Int) {
    val badgeIntent = Intent("android.intent.action.BADGE_COUNT_UPDATE")
    badgeIntent.putExtra("badge_count", notiCnt)
    badgeIntent.putExtra("badge_count_package_name", context.packageName)
    badgeIntent.putExtra("badge_count_class_name", MainActivity::class.java.name)

    context.sendBroadcast(badgeIntent)
}