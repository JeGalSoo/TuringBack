import axios from "axios"
export const queryKey = ['repoData']
export const getAllList = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'position' } }
    )
    return data
}

export const getTeamAndRegion = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'combine' } }
    )
    return data
}

export const getHomeAndAway = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'versus' } }
    )
    return data
}

export const getNoWayHome = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'stadium', 'oq': 'noHome' } }
    )
    return data
}

