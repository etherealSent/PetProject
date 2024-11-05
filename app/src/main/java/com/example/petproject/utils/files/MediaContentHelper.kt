package com.example.petproject.utils.files

import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore

class MediaContentHelper {

    fun getImageContentUri(): Uri =
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

    fun generateImageContentValues(fileInfo: FileInfo) = ContentValues().apply {
        this.put(MediaStore.Images.Media.DISPLAY_NAME, fileInfo.name)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            this.put(MediaStore.Images.Media.RELATIVE_PATH, fileInfo.relativePath)
        }
        this.put(MediaStore.Images.Media.MIME_TYPE, fileInfo.mimeType)
    }

}