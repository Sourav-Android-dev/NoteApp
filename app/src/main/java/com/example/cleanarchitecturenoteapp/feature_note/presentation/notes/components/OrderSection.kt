package com.example.cleanarchitecturenoteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.example.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import com.example.cleanarchitecturenoteapp.feature_note.presentation.notes.components.DefaultRadioButton

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = modifier.fillMaxWidth()
        ){
            DefaultRadioButton(text = "Title",
                selected = noteOrder is NoteOrder.Title ,
                onSelect = {onOrderChange(NoteOrder.Title(noteOrder.orderType))})
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Date",
                selected = noteOrder is NoteOrder.Date ,
                onSelect = {onOrderChange(NoteOrder.Date(noteOrder.orderType))})
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Color",
                selected = noteOrder is NoteOrder.Color ,
                onSelect = {onOrderChange(NoteOrder.Color(noteOrder.orderType))})
        }
        Spacer(modifier = modifier.height(16.dp))
        Row(
            modifier = modifier.fillMaxWidth()
        ){
            DefaultRadioButton(text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending ,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(text = "Descending",
                selected = noteOrder is NoteOrder.Date ,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                })
        }

    }
}
