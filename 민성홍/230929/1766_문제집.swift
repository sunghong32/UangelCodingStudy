//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/09/29.
////  백준 1766: 문제집
////  메모리:72868KB
////  시간: 264ms

final class Heap<T: Equatable> {
    private var nodes: [T] = []
    private let sort: (T,T) -> Bool

    init(sort: @escaping ((T,T) -> Bool)) {
        self.sort = sort
    }

    var isEmpty: Bool {
        nodes.isEmpty
    }

    func insert(_ data: T) {
        var index = nodes.count
        nodes.append(data)

        while index >= 0, sort(nodes[index], nodes[(index-1)/2]) {
            nodes.swapAt(index, (index - 1) / 2)
            index = (index - 1) / 2
        }
    }

    func delete() -> T {
        if nodes.count == 1 {
            return nodes.removeFirst()
        }

        let data = nodes.first!
        nodes.swapAt(0, nodes.count - 1)
        _ = nodes.popLast()

        let limit = nodes.count
        var index = 0

        while index < limit {
            let leftChild = index * 2 + 1
            let rightChild = leftChild + 1

            let children = [leftChild, rightChild]
                .filter{ $0 < limit && sort(nodes[$0], nodes[index])}
                .sorted{ sort(nodes[$0], nodes[$1])}

            if children.isEmpty { break }

            nodes.swapAt(index, children.first!)
            index = children.first!
        }

        return data
    }
}

let nm: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
let n = nm[0]
let m = nm[1]

var indegree: Array = Array(repeating: 0, count: n+1)
var earlyProblem: Array = Array(repeating: [Int](), count: n+1)

for _ in 0..<m {
    let ab = readLine()!.split(separator: " ").map{Int($0)!}
    let a = ab[0], b = ab[1]
    indegree[b] += 1
    earlyProblem[a].append(b)
}

func topologySort() -> String {
    var visitedNode = [Int]()
    let queue = Heap<Int>(sort: <)
    for i in 1...n where indegree[i] == 0 {
        queue.insert(i)
    }

    while !queue.isEmpty {
        let cur = queue.delete()
        visitedNode.append(cur)
        for next in earlyProblem[cur] {
            indegree[next] -= 1
            if indegree[next] == 0 {
                queue.insert(next)
            }
        }
    }

    return visitedNode.map{String($0)}.joined(separator: " ")
}

print(topologySort())
