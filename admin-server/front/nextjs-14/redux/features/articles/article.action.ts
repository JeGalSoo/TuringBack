import { createAction, handleAction } from "redux-actions";

export const articleConstants = {
    ARTICLES_REQUEST : 'GET_ARTICLES',
    ARTICLES_SUCCESS : 'GET_SUCCESS',
    ARTICLES_FAILURE : 'GET_FAILURE',
}

export const GET_ARTICLES = createAction(articleConstants.ARTICLES_SUCCESS)

