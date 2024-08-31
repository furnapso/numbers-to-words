import {ofetch} from "ofetch";

const client = ofetch.create({
    baseURL: import.meta.env.BASE_URL,
    mode: "cors"
});

async function convertNumber(number: string): Promise<string> {
    const {data} = await client("/convert", {params: {number}});
    return data;
}

export default {convertNumber};