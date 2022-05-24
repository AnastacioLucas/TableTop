package com.udacity.tabletop.locationreminders.data

import com.udacity.tabletop.locationreminders.data.dto.TableTopDTO
import com.udacity.tabletop.locationreminders.data.dto.Result

/**
 * Main entry point for accessing reminders data.
 */
interface TableTopDataSource {
    suspend fun getReminders(): Result<List<TableTopDTO>>
    suspend fun saveReminder(reminder: TableTopDTO)
    suspend fun getReminder(id: String): Result<TableTopDTO>
    suspend fun deleteAllReminders()
}