import axios from "axios"
<<<<<<< HEAD



export const getAllPositionKey = ['getAllPosition']
export const getAllPosition = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search/position-list`,
        { params: { q: 'player', oq: 'position' } }
=======
export const queryKey = ['repoData']
export const getAllList = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'position' } }
>>>>>>> jgs
    )
    return data
}

<<<<<<< HEAD
export const findAllPositionincludeNullKey = ['findAllPositionincludeNull']
export const findAllPositionincludeNull = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search/position-list-includeNull`,
        { params: { q: 'player', oq: 'position' } }
=======
export const getTeamAndRegion = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'combine' } }
>>>>>>> jgs
    )
    return data
}

<<<<<<< HEAD
export const findAllByPositionAndTeamIDKey = ['findAllByPositionAndTeamID']
export const findAllByPositionAndTeamID = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search/findGK-SuwonTeamId`,
        { params: { q: 'player', oq: 'position' } }
=======
export const getHomeAndAway = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'versus' } }
>>>>>>> jgs
    )
    return data
}

<<<<<<< HEAD
export const findAllByPositionAndTeamNameKey = ['findAllByPositionAndTeamName']
export const findAllByPositionAndTeamName = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search/findGK-SuwonTeamName`,
        { params: { q: 'player', oq: 'position' } }
    )
    return data
}

export const findAllByPlayerNameAndHeightAndTeamKey = ['findAllByPlayerNameAndHeightAndTeam']
export const findAllByPlayerNameAndHeightAndTeam = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search/findPlayer-Name-Height-team`,
        { params: { q: 'player', oq: 'position' } }
    )
    return data
}

export const findAllByPlayerNameAndHeightKey = ['findAllByPlayerNameAndHeight']
export const findAllByPlayerNameAndHeight = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search/findPlayer-Name-Height`,
        { params: { q: 'player', oq: 'position' } }
=======
export const getNoWayHome = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'noHome' } }
>>>>>>> jgs
    )
    return data
}

