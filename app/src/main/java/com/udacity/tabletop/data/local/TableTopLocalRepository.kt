package com.udacity.tabletop.data.local

import com.udacity.tabletop.data.TableTopDataSource
import com.udacity.tabletop.data.dto.TableTopDTO
import com.udacity.tabletop.data.dto.Result
import kotlinx.coroutines.*

/**
 * Concrete implementation of a data source as a db.
 *
 * The repository is implemented so that you can focus on only testing it.
 *
 * @param remindersDao the dao that does the Room db operations
 * @param ioDispatcher a coroutine dispatcher to offload the blocking IO tasks
 */
class TableTopLocalRepository(
    private val remindersDao: TableTopDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : TableTopDataSource {

    /**
     * Get the reminders list from the local db
     * @return Result the holds a Success with all the reminders or an Error object with the error message
     */
    override suspend fun getReminders(): Result<List<TableTopDTO>> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(remindersDao.getReminders())
        } catch (ex: Exception) {
            Result.Error(ex.localizedMessage)
        }
    }

    /**
     * Insert a reminder in the db.
     * @param reminder the reminder to be inserted
     */
    override suspend fun saveReminder(reminder: TableTopDTO) =
        withContext(ioDispatcher) {
            remindersDao.saveReminder(reminder)
        }

    /**
     * Get a reminder by its id
     * @param id to be used to get the reminder
     * @return Result the holds a Success object with the Reminder or an Error object with the error message
     */
    override suspend fun getReminder(id: String): Result<TableTopDTO> = withContext(ioDispatcher) {
        try {
            val reminder = remindersDao.getReminderById(id)
            if (reminder != null) {
                return@withContext Result.Success(reminder)
            } else {
                return@withContext Result.Error("Reminder not found!")
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e.localizedMessage)
        }
    }

    /**
     * Deletes all the reminders in the db
     */
    override suspend fun deleteAllReminders() {
        withContext(ioDispatcher) {
            remindersDao.deleteAllReminders()
        }
    }
}
