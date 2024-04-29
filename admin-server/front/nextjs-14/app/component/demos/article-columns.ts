import { GridColDef } from "@mui/x-data-grid";

export default function ArticleColumns():GridColDef[]{
    return [
  { field: 'article_id', headerName: 'ID',type: 'number',width: 90 },
  {
    field: 'title',
    headerName: 'Title',
    width: 150,
    editable: true,
  },
  {
    field: 'content',
    headerName: 'Content',
    width: 150,
    editable: true,
  },
  {
    field: 'writer',
    headerName: 'Writer',
    width: 110,
    editable: true,
  },
  {
    field: 'registerDate',
    headerName: 'RegisterDate',
    width: 160,
    // valueGetter: (value, row) => `${row.firstName || ''} ${row.lastName || ''}`,
  },
]
}