import { createAsyncThunk } from "@reduxjs/toolkit";
import { IBoard } from "../model/board";
import axios from "axios";
import { findAllBoardsAPI } from "./board-.api";

export const findAllBoards: any = createAsyncThunk(
    'boards/findAllBoards',
    async (page: number)=> await  findAllBoardsAPI(page)
)