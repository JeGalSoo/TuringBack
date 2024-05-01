import axios from "axios"
export const queryKey = ['repoData']
export const getAllList = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { 'q': 'schedule', 'oq': 'versus' } }
    )
    return data
}

export const getTeamAndRegion = async () => {
    const { data } = await axios.get(`${process.env.API_URL}/search`,
        { params: { q: 'schedule', oq: 'match' } }
    )
    return data
}
