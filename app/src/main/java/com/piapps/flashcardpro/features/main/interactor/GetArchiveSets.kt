package com.piapps.flashcardpro.features.main.interactor

import com.piapps.flashcardpro.core.db.DatabaseRepository
import com.piapps.flashcardpro.core.db.tables.SetDb
import com.piapps.flashcardpro.core.extension.doAsync
import com.piapps.flashcardpro.core.extension.uiThread
import javax.inject.Inject

/**
 * Created by abduaziz on 2019-09-27 at 23:30.
 */

class GetArchiveSets
@Inject constructor(private val repository: DatabaseRepository) {
    operator fun invoke(onResult: (List<SetDb>) -> Unit = {}) {
        doAsync {
            val result = repository.getArchiveSets()
            uiThread {
                onResult(result)
            }
        }
    }
}