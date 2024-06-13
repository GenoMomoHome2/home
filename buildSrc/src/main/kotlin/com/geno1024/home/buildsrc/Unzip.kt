package com.geno1024.home.buildsrc

import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipFile

object Unzip
{
    fun unzip(zipFile: File, target: File, verbose: Boolean = false, overrideIfExists: Boolean = true) = with(ZipFile(zipFile)) {
        if (!target.exists())
        {
            target.mkdirs()
        }
        else if (overrideIfExists)
        {
            target.deleteRecursively()
            target.mkdirs()
        }
        entries().iterator().forEachRemaining { entry ->
            if (verbose)
            {
                println("Flattening ${entry.name}")
            }
            if (entry.isDirectory)
            {
                File("$target/$name").mkdirs()
            }
            else
            {
                getInputStream(entry).transferTo(FileOutputStream("$target/${entry.name}"))
            }
        }
    }
}
