import { createAction, handleAction } from "redux-actions";

export const userConstants = {
    ARTICLES_REQUEST : 'GET_ARTICLES',
    ARTICLES_SUCCESS : 'GET_SUCCESS',
    ARTICLES_FAILURE : 'GET_FAILURE',
}

export const GET_ARTICLES = createAction(userConstants.ARTICLES_SUCCESS)

